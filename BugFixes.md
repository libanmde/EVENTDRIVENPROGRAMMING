# Bug Fix Documentation

## Bug 1: Blocking the EDT
- **Symptom:** The interface becomes unresponsive while the button handler waits.
- **Cause:** `Thread.sleep()` was called directly inside the Swing action listener, which runs on the EDT.
- **Fix:** The delay is performed on a background thread. `SwingUtilities.invokeLater()` updates the label and button on the EDT.
- **Code change:** Created a new `Thread` for the simulated long task and moved Swing component updates into `invokeLater()`.

## Bug 2: Missing Listener
- **Symptom:** Clicking Increment does not change the count.
- **Cause:** No `ActionListener` was registered with the button.
- **Fix:** Added an action listener that increments the count and updates the label.
- **Code change:** `incrementButton.addActionListener(e -> { count++; countLabel.setText("Count: " + count); });`

## Bug 3: Wrong Thread
- **Symptom:** The original code changed a Swing label directly from a background thread.
- **Cause:** Swing components should be updated on the Event Dispatch Thread.
- **Fix:** The background thread obtains the time, then schedules the label update with `SwingUtilities.invokeLater()`.
- **Code change:** The label update is wrapped in `SwingUtilities.invokeLater()`.

## Bug 4: Memory Leak
- **Symptom:** Buttons disappear from the panel, but the list continues to retain references to them.
- **Cause:** `removeAll()` removed the buttons from the user interface but did not clear the `createdButtons` list.
- **Fix:** Clear the list when removing all buttons.
- **Code change:** Added `createdButtons.clear()` after `buttonPanel.removeAll()`.
