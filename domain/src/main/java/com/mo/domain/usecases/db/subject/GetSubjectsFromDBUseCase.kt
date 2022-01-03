package com.mo.domain.usecases.db.subject

import com.mo.data.models.State
import com.mo.data.models.Subject
import com.mo.data.repositories.subject.SubjectRepository
import com.mo.domain.usecases.SuspendUseCase

interface GetSubjectsFromDBUseCase : SuspendUseCase<List<Subject>>

internal class GetSubjectsFromDBUseCaseImpl(
    private val subjectRepository: SubjectRepository
) : GetSubjectsFromDBUseCase {

    override suspend fun invoke(): State<List<Subject>> =
        subjectRepository.getSubjectsFromDB()
}