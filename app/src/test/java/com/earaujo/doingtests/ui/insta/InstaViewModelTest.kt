package com.earaujo.doingtests.ui.insta

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.earaujo.doingtests.data.model.Insta
import com.earaujo.doingtests.data.repository.InstaRepository
import com.earaujo.doingtests.data.repository.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class InstaViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var observer: Observer<Resource<Insta>>

    @Mock
    lateinit var repository: InstaRepository

    lateinit var instaViewModel: InstaViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        instaViewModel = InstaViewModel(repository)
    }

    @Test
    fun addition_isCorrect() {
        val liveData = MutableLiveData<Resource<Insta>>()
        val instaData = Insta(
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Feu.jpg?1555454871499",
            "eduardoaraujo",
            "https://cdn.glitch.com/c335e4ce-57d4-4636-951c-12539010222a%2Fbeach.jpg?1555454872159",
            "Este é uma foto de praia"
        )
        val res = Resource.success(instaData)
        liveData.value = res

        Mockito.`when`(this.repository.getData()).thenAnswer {
            return@thenAnswer liveData
        }

        instaViewModel.getData().observeForever(observer)
        Mockito.verify(observer).onChanged(res)
    }
}