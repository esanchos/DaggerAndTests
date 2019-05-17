package com.earaujo.doingtests.ui.insta

import android.arch.lifecycle.MutableLiveData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.earaujo.doingtests.R
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.Resource
import com.earaujo.doingtests.util.ViewModelUtil
import com.nhaarman.mockito_kotlin.whenever
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import android.content.Intent
import android.support.test.runner.intercepting.SingleActivityFactory
import org.mockito.Mock

@RunWith(AndroidJUnit4::class)
@LargeTest
class InstaActivityTest {

    private val injectedFactory = object : SingleActivityFactory<InstaActivity>(InstaActivity::class.java) {
        override fun create(intent: Intent): InstaActivity {
            val activity = InstaActivity()
            activity.viewModelFactory = ViewModelUtil.createFor(instaViewModel)
            return activity
        }
    }

    @get:Rule
    var testRule: ActivityTestRule<InstaActivity> = ActivityTestRule(injectedFactory, false, false)

    @Mock
    lateinit var instaViewModel: InstaViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun WhenReceiveASuccesRequestWithSponsor_TitleAuthorAuthorNameAuthorCommentAndSponsorShouldApperPropperly() {
        val liveData = MutableLiveData<Resource<Insta>>()
        val instaData = Insta(
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Feu.jpg?1555454871499",
            "eduardoaraujo",
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Fbeach.jpg?1555454872159",
            "Esta é uma foto de praia",
            true
        )
        liveData.postValue(Resource.success(instaData))

        // given
        whenever(instaViewModel.getData).thenReturn(liveData)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.tv_title_author_name)).check(matches(withText("eduardoaraujo")))
        onView(withId(R.id.tv_desc_author_name)).check(matches(withText("eduardoaraujo")))
        onView(withId(R.id.tv_desc_author_comment)).check(matches(withText("Esta é uma foto de praia")))
        onView(withId(R.id.tv_title_sponsored)).check(matches(isDisplayed()))
    }

    @Test
    fun WhenReceiveASuccesRequestWithoutSponsor_TitleAuthorAuthorNameAuthorCommentAndSponsorShouldApperPropperly() {
        val liveData = MutableLiveData<Resource<Insta>>()
        val instaData = Insta(
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Feu.jpg?1555454871499",
            "eduardoaraujo",
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Fbeach.jpg?1555454872159",
            "Esta é uma foto de praia",
            false
        )
        liveData.postValue(Resource.success(instaData))

        // given
        whenever(instaViewModel.getData).thenReturn(liveData)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.tv_title_author_name)).check(matches(withText("eduardoaraujo")))
        onView(withId(R.id.tv_desc_author_name)).check(matches(withText("eduardoaraujo")))
        onView(withId(R.id.tv_desc_author_comment)).check(matches(withText("Esta é uma foto de praia")))
        onView(withId(R.id.tv_title_sponsored)).check(matches(not(isDisplayed())))
    }

    @Test
    fun WhenStartARequetAndReceivedALoading_SpinnerShouldAppear() {
        val liveData = MutableLiveData<Resource<Insta>>()
        liveData.postValue(Resource.loading())

        // given
        whenever(instaViewModel.getData).thenReturn(liveData)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.pb_loading)).check(matches(isDisplayed()))
    }

    @Test
    fun WhenStartARequetAndReceivedASuccess_SpinnerShouldNotAppear() {
        val liveData = MutableLiveData<Resource<Insta>>()
        liveData.postValue(Resource.success(mock(Insta::class.java)))

        // given
        whenever(instaViewModel.getData).thenReturn(liveData)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.pb_loading)).check(matches(not(isDisplayed())))
    }

    /*@Test
    fun userInfo_returns_no_info_by_default() {
        // given
        // nothing is stored
        whenever(userPref.hasAge()).thenReturn(false)
        whenever(userPref.hasName()).thenReturn(false)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.user_info)).check(matches(withText("No info")))
    }

    @Test
    fun userInfo_returns_stored_userInfo() {
        // given
        // "Mike" and 20 is stored
        whenever(userPref.hasAge()).thenReturn(true)
        whenever(userPref.hasName()).thenReturn(true)
        whenever(userPref.name).thenReturn("Mike")
        whenever(userPref.age).thenReturn(20)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.user_info)).check(matches(withText("Current info: Name Mike Age 20")))
    }

    @Test
    fun userInfo_updates_with_input() {
        // given
        // api returns posted user
        val user = User("John", 10)
        whenever(registerApi.post(user)).thenReturn(Maybe.just(user))

        // nothing is stored
        whenever(userPref.hasAge()).thenReturn(false)
        whenever(userPref.hasName()).thenReturn(false)

        // when
        testRule.launchActivity(null)

        onView(withId(R.id.name)).perform(typeText("John"), closeSoftKeyboard())
        onView(withId(R.id.age)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.register)).perform(click())

        // then
        onView(withId(R.id.user_info)).check(matches(withText("Current info: Name John Age 10")))
    }

    @Test
    fun errorMessage_shows_with_illegal_input() {
        // given
        // api returns an error
        whenever(registerApi.post(any())).thenReturn(Maybe.error(IllegalArgumentException("error")))

        // nothing is stored
        whenever(userPref.hasAge()).thenReturn(false)
        whenever(userPref.hasName()).thenReturn(false)

        // when
        testRule.launchActivity(null)

        onView(withId(R.id.name)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.age)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.register)).perform(click())

        // then
        onView(withId(R.id.warning)).check(matches(withText("error")))
        onView(withId(R.id.user_info)).check(matches(withText("No info")))
    }*/

}
