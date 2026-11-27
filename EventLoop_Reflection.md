# Activity 2: Build the Event Loop

## Event cards used
1. Button A Clicked
2. Button B Clicked
3. Text Field Updated: "Hello"
4. Timer Fired
5. Window Resized
6. Checkbox Selected
7. Menu Item Clicked
8. Key Pressed: "A"
9. Mouse Moved
10. Button A Clicked

## Example event processing

| Event | Possible handler/action |
|---|---|
| Button A Clicked | Run the action registered for Button A |
| Button B Clicked | Run the action registered for Button B |
| Text Field Updated | Read or validate the new text |
| Timer Fired | Run the scheduled timer task |
| Window Resized | Re-layout or repaint the window |
| Checkbox Selected | Update the selected setting |
| Menu Item Clicked | Perform the selected menu command |
| Key Pressed: A | Process the keyboard input |
| Mouse Moved | Update pointer-related interaction |
| Button A Clicked | Run Button A's action again |

## Questions about a blocked event loop

1. **What happened to the other events while you were stuck on the slow handler?**  
   The other events remained waiting in the event queue until the current handler finished.

2. **What would a user see in a real application?**  
   The application could appear frozen or unresponsive. Button clicks and window updates may not be handled promptly.

3. **How could this problem be fixed?**  
   Move long-running work away from the GUI event-dispatch thread, for example by using a background worker. Update Swing components on the EDT.

## Reflection (5–7 sentences)

The event queue stores events that are waiting to be handled by the application. The event loop checks the queue and dispatches events so that the appropriate handler can process them. Events are generally processed one at a time by the GUI event-dispatch thread. If one handler takes too long, other events remain in the queue and the application may appear frozen. The event loop should therefore not be blocked by long-running tasks. Time-consuming work should be performed in a background thread, while updates to Swing components should be made on the EDT. This helps the application remain responsive to the user.
