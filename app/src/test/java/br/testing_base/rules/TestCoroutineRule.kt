package br.testing_base.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@OptIn(ExperimentalCoroutinesApi::class)
class TestCoroutineRule : TestRule {

    private val testCoroutineDispatcher = UnconfinedTestDispatcher()

    private val testCoroutineScope = TestScope()

    override fun apply(base: Statement, description: Description): Statement =
        object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                Dispatchers.setMain(testCoroutineDispatcher)

                base.evaluate()

                Dispatchers.resetMain()
            }
        }

    fun runBlockingTest(block: suspend TestScope.() -> Unit) =
        testCoroutineScope.runTest { block() }
}