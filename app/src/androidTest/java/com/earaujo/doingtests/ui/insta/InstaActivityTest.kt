package com.earaujo.doingtests.ui.insta

import android.arch.lifecycle.MutableLiveData
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.earaujo.doingtests.DoingTests
import com.earaujo.doingtests.R
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.InstaRepository
import com.earaujo.doingtests.data.repository.Resource
import com.earaujo.doingtests.data.repository.Status
import com.earaujo.doingtests.di.AppComponentTest
import com.earaujo.doingtests.di.DaggerAppComponentTest
import com.earaujo.doingtests.modules.AppModule
import com.earaujo.doingtests.modules.insta.InstaRepositoryModuleTest
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@LargeTest
class InstaActivityTest {

    @get:Rule
    val testRule: ActivityTestRule<InstaActivity> = ActivityTestRule(InstaActivity::class.java, false, false)

    @Inject
    lateinit var instaRepository: InstaRepository

    private lateinit var appComponentTest: AppComponentTest

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val app = InstrumentationRegistry.getTargetContext().applicationContext as DoingTests
        appComponentTest = DaggerAppComponentTest.builder()
            .appModule(AppModule(app))
            .instaRepositoryModule(InstaRepositoryModuleTest())
            .build()
        app.appComponent = appComponentTest
        appComponentTest.inject(this)
        System.out.println("==== TestAppComponent injected")
    }

    @Test
    fun userInfo_returns_no_info_by_default() {
        val liveData = MutableLiveData<Resource<Insta>>()
        val instaData = Insta(
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Feu.jpg?1555454871499",
            "eduardoaraujo",
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Fbeach.jpg?1555454872159",
            "Esta é uma foto de praia",
            true
        )
        liveData.postValue(Resource(Status.SUCCESS, instaData))

        // given
        whenever(instaRepository.getData()).thenReturn(liveData)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.tv_title_author_name)).check(matches(withText("eduardoaraujo")))
    }

    @Test
    fun userInfo_returns_no_info_by_default2() {
        val liveData = MutableLiveData<Resource<Insta>>()
        val instaData = Insta(
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Feu.jpg?1555454871499",
            "eduardoaraujo",
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Fbeach.jpg?1555454872159",
            "Esta é uma foto de praia",
            false
        )
        liveData.postValue(Resource(Status.SUCCESS, instaData))

        // given
        whenever(instaRepository.getData()).thenReturn(liveData)

        // when
        testRule.launchActivity(null)

        // then
        onView(withId(R.id.tv_title_author_name)).check(matches(withText("eduardoaraujo")))
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
