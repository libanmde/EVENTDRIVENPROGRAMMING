import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LibraryManagementSystem extends JFrame {
    private static class Book {
        String title;
        boolean borrowed;

        Book(String title) {
            this.title = title;
            this.borrowed = false;
        }

        @Override
        public String toString() {
            return title + (borrowed ? " (Borrowed)" : " (Available)");
        }
    }

    private final List<Book> books = new ArrayList<>();
    private final DefaultListModel<Book> listModel = new DefaultListModel<>();
    private final JList<Book> bookList = new JList<>(listModel);
    private final JTextField searchField = new JTextField(18);
    private final JLabel statusLabel = new JLabel("Select a book to begin.");

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        books.add(new Book("Introduction to Java"));
        books.add(new Book("Database Systems"));
        books.add(new Book("Computer Networks"));
        books.add(new Book("Systems Analysis and Design"));
        books.add(new Book("Object-Oriented Programming"));
        refreshList(books);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search title:"));
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        JButton clearButton = new JButton("Clear");
        searchPanel.add(searchButton);
        searchPanel.add(clearButton);
        add(searchPanel, BorderLayout.NORTH);

        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(bookList), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel actionPanel = new JPanel();
        JButton borrowButton = new JButton("Borrow Selected");
        JButton returnButton = new JButton("Return Selected");
        actionPanel.add(borrowButton);
        actionPanel.add(returnButton);
        bottomPanel.add(actionPanel, BorderLayout.NORTH);
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        searchButton.addActionListener(e -> searchBooks());
        clearButton.addActionListener(e -> {
            searchField.setText("");
            refreshList(books);
            statusLabel.setText("Search cleared.");
        });
        borrowButton.addActionListener(e -> borrowSelectedBook());
        returnButton.addActionListener(e -> returnSelectedBook());
        bookList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && bookList.getSelectedValue() != null) {
                statusLabel.setText("Selected: " + bookList.getSelectedValue().title);
            }
        });

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void refreshList(List<Book> source) {
        listModel.clear();
        for (Book book : source) {
            listModel.addElement(book);
        }
    }

    private void searchBooks() {
        String query = searchField.getText().trim().toLowerCase(Locale.ROOT);
        List<Book> matches = new ArrayList<>();
        for (Book book : books) {
            if (book.title.toLowerCase(Locale.ROOT).contains(query)) {
                matches.add(book);
            }
        }
        refreshList(matches);
        statusLabel.setText(matches.isEmpty()
                ? "No matching books found."
                : matches.size() + " matching book(s) found.");
    }

    private void borrowSelectedBook() {
        Book selected = bookList.getSelectedValue();
        if (selected == null) {
            statusLabel.setText("Please select a book first.");
        } else if (selected.borrowed) {
            statusLabel.setText("This book is already borrowed.");
        } else {
            selected.borrowed = true;
            refreshCurrentSearch();
            statusLabel.setText("Borrowed: " + selected.title);
        }
    }

    private void returnSelectedBook() {
        Book selected = bookList.getSelectedValue();
        if (selected == null) {
            statusLabel.setText("Please select a book first.");
        } else if (!selected.borrowed) {
            statusLabel.setText("This book is already available.");
        } else {
            selected.borrowed = false;
            refreshCurrentSearch();
            statusLabel.setText("Returned: " + selected.title);
        }
    }

    private void refreshCurrentSearch() {
        String query = searchField.getText().trim().toLowerCase(Locale.ROOT);
        List<Book> matches = new ArrayList<>();
        for (Book book : books) {
            if (book.title.toLowerCase(Locale.ROOT).contains(query)) {
                matches.add(book);
            }
        }
        refreshList(matches);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementSystem().setVisible(true));
    }
}
