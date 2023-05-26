package br.com.breno.blocknotescompose.di

import br.com.breno.blocknotescompose.data.local.database.NoteDataBase
import br.com.breno.blocknotescompose.data.repository.AddNoteRepositoryImpl
import br.com.breno.blocknotescompose.data.repository.FetchNotesRepositoryImpl
import br.com.breno.blocknotescompose.domain.repository.AddNoteRepository
import br.com.breno.blocknotescompose.domain.repository.FetchNotesRepository
import br.com.breno.blocknotescompose.domain.usecase.AddNoteUseCase
import br.com.breno.blocknotescompose.domain.usecase.FetchNotesUseCase
import br.com.breno.blocknotescompose.presentation.viewmodel.AddNoteViewModel
import br.com.breno.blocknotescompose.presentation.viewmodel.MainViewModel
import br.com.breno.blocknotescompose.presentation.viewmodel.TestViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single { NoteDataBase.createDataBase(androidContext()) }

    single { get<NoteDataBase>().noteDao() }
}

val domainModule = module {
    factory<FetchNotesRepository> {
        FetchNotesRepositoryImpl(notesDao = get())
    }

    factory<AddNoteRepository> {
        AddNoteRepositoryImpl(notesDao = get())
    }

    factory {
        FetchNotesUseCase(fetchNotesRepository = get())
    }

    factory {
        AddNoteUseCase(repository = get())
    }
}

val presentationModule = module {
    viewModel {
        MainViewModel(fetchNotes = get())
    }

    viewModel<AddNoteViewModel>()

    viewModel<TestViewModel>()
}