# Event-Driven System Design

## System Name: Library Management System

## Part 1: Event Sources

1. Search button – generates a search-button-clicked event.
2. Borrow button – generates a borrow-button-clicked event.
3. Return button – generates a return-button-clicked event.
4. Book selection list – generates a book-selection-changed event.
5. Clear button – generates a clear-button-clicked event.

## Part 2: Events

| Event name | Source | Description |
|---|---|---|
| Search clicked | Search button | User requests a book search |
| Borrow clicked | Borrow button | User requests to borrow the selected book |
| Return clicked | Return button | User requests to return the selected book |
| Selection changed | Book list | User selects a book |
| Clear clicked | Clear button | User clears the search field and message |

## Part 3: Event Handlers

| Event | Handler action |
|---|---|
| Search clicked | Search the sample book list and display matching results |
| Borrow clicked | Check availability, mark the selected book as borrowed, and update the display |
| Return clicked | Mark the selected book as available and update the display |
| Selection changed | Display the selected book's details |
| Clear clicked | Clear the search field and status message |

## Part 4: Event Flow Diagram

```text
User clicks or selects a control
             |
             v
        Event source
             |
             v
       Event generated
             |
             v
    Listener receives event
             |
             v
      Event handler runs
             |
             v
   Update book data and GUI
```

## Part 5: Potential Issues

1. **A user tries to borrow a book that is already borrowed.**  
   Prevention: Check the book's availability before changing its status and show a clear message.

2. **A user tries to return a book that is already available.**  
   Prevention: Check the current status before processing the return.

3. **A search does not find a matching title.**  
   Prevention: Display a “No matching books found” message instead of leaving the result unclear.

## Prototype requirements
The Java prototype has interactive Search, Borrow, Return, and Clear controls. Each control has an event handler, the interface displays the book list and status, and the application is launched on the Swing Event Dispatch Thread.
