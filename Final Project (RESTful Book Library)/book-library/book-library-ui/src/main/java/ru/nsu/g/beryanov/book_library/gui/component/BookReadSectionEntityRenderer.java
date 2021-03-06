package ru.nsu.g.beryanov.book_library.gui.component;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.g.beryanov.book_library.dto.BookDto;
import ru.nsu.g.beryanov.book_library.dto.BookReadDto;
import ru.nsu.g.beryanov.book_library.service.BookService;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

@Service
public class BookReadSectionEntityRenderer extends JLabel implements ListCellRenderer<BookReadDto> {
    @Autowired
    private BookService bookService;

    public BookReadSectionEntityRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookReadDto> list, BookReadDto bookReadDto, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        BookDto bookDto = bookService.findById(bookReadDto.getBookId());
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(ArrayUtils.toPrimitive(bookDto.getImage())).getImage().getScaledInstance(40, 60,  java.awt.Image.SCALE_SMOOTH));
        setIcon(imageIcon);

        setPreferredSize(new Dimension(330, 70));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        setText(" " + bookDto.getAuthorByAuthorId().getName() + " -> " + bookDto.getName() + " -> " + sdf.format(bookReadDto.getDateOfCompletion()));
        return this;
    }
}
