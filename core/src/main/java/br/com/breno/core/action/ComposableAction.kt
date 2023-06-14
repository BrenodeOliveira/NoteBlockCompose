package br.com.breno.core.action

sealed class ComposableAction: UIAction {
    object InitializingCompose: ComposableAction()
}
