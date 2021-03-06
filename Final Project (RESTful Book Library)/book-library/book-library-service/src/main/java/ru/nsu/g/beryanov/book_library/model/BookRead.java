package ru.nsu.g.beryanov.book_library.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "book_read", schema = "book_library")
public class BookRead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "quote_id")
    private Long quoteId;
    @Column(name = "assessment_id")
    private Long assessmentId;
    @Column(name = "date_of_completion")
    private Date dateOfCompletion;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Book bookByBookId;
    @ManyToOne
    @JoinColumn(name = "quote_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Quote quoteByQuoteId;
    @ManyToOne
    @JoinColumn(name = "assessment_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Assessment assessmentByAssessmentId;
}
