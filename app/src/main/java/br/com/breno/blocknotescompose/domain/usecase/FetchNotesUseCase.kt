package br.com.breno.blocknotescompose.domain.usecase

import br.com.breno.blocknotescompose.domain.repository.FetchNotesRepository

class FetchNotesUseCase(private val fetchNotesRepository: FetchNotesRepository) {
    suspend operator fun invoke() = fetchNotesRepository.fetchNotes()
}