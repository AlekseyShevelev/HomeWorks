package org.example.task1.services;

import lombok.RequiredArgsConstructor;
import org.example.task1.aspects.TrackUserAction;
import org.example.task1.model.Note;
import org.example.task1.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    @TrackUserAction
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @TrackUserAction
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @TrackUserAction
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @TrackUserAction
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
