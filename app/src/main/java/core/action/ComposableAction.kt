package core.action

sealed class ComposableAction: UIAction {
    object InitializingCompose: ComposableAction()
}
