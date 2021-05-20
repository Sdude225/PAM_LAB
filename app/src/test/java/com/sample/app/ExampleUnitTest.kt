package com.sample.app

import com.sample.app.network.models.SearchResult
import com.sample.app.feed.models.Item
import com.sample.app.network.Service
import com.sample.app.repo.ApiResult
import com.sample.app.viewModel.FragViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import okhttp3.internal.tls.OkHostnameVerifier.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.whenever
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.net.URL

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@ExperimentalCoroutinesApi
class ExampleUnitTest {
    val dispatcher : TestCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }

    fun onSuccessReq_updateUi() = runBlockingTest {

        val resultMock = mock<Item>()
        val apiMock = mock<Service>()
        val repoMock = mock<ApiResult>()
        val viewModelMock = mock<FragViewModel>()

        val attr = mock<SearchResult.Attributes>()
        whenever(attr.title).thenReturn("prorab")
        whenever(attr.location).thenReturn("telecentru")
        whenever(attr.snippet).thenReturn("snippet")
        whenever(attr.salary).thenReturn("7 figures")
        whenever(attr.source).thenReturn("pamflet")
        whenever(attr.type).thenReturn("ciotkii")
        whenever(attr.link).thenReturn("test.com")
        whenever(attr.company).thenReturn("srl stroika")
        whenever(attr.updated).thenReturn("always")
        whenever(attr.id).thenReturn("3432")

        val links = mock<SearchResult.Links>()
        whenever(links.first).thenReturn(URL("test.com"))
        whenever(links.last).thenReturn(URL("test.com"))

        val obj = mock<SearchResult.ContentObj>()
        whenever(obj.attributes).thenReturn(attr)
        whenever(obj.id).thenReturn("777")

        val response = mock<SearchResult>()
        whenever(response.data).thenReturn(arrayListOf(obj))


        whenever(apiMock.search("stoika")).thenReturn(response)

        val expectedData = arrayOf(
            Item(obj.attributes.title,
                obj.attributes.location,
                obj.attributes.snippet,
                obj.attributes.salary,
                obj.attributes.source,
                obj.attributes.type,
                obj.attributes.link,
                obj.attributes.company,
                obj.attributes.updated,
                obj.attributes.id,
            )
        )

        viewModelMock.getContent()

        verify(apiMock).search("stroika")
        verify(repoMock).search("stroika")
        verify(viewModelMock).getContent()
    }

    @Test
    fun onReqError_throwAlert() = runBlockingTest {

        val resultMock = mock<Item>()
        val apiMock = mock<Service>()
        val repoMock = mock<ApiResult>()
        val viewModelMock = mock<FragViewModel>()

        val error = Error("sisul vine")
        whenever(apiMock.search("drug dealer")).thenThrow(error)

        viewModelMock.getContent()

        verify(apiMock).search("drug dealer")
        verify(repoMock).search("test")
        verify(viewModelMock).getContent()
    }

}
