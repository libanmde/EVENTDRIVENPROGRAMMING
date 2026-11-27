# Activity 3: Procedural vs Event-Driven Programming

## Procedural calculator questions

1. **What is the exact order of steps?**  
   The program asks for the first number, asks for an operator, asks for the second number, performs the calculation, and displays the result.

2. **What happens if the user enters the wrong input at step 2?**  
   If the operator is not one of the supported symbols, the program displays an invalid-operator message and ends.

3. **Can the user calculate again without restarting?**  
   No. This version performs one calculation and then finishes.

4. **Who controls the flow?**  
   The program controls the sequence of steps.

## Event-driven calculator questions

1. **Can the user click buttons in any order?**  
   The user can interact with the buttons in different orders, although a meaningful calculation still requires entering numbers and selecting an operator in a sensible sequence.

2. **What happens if the user makes a mistake?**  
   The user can press C to clear the display and start again. Division by zero displays an error.

3. **Can the user calculate again without restarting?**  
   Yes. The window remains open and the user can perform more calculations.

4. **Who controls the flow?**  
   The user's actions generate events, and the registered handlers respond to those events.

5. **How many event handlers are in this program?**  
   The program registers handlers for number buttons, operator buttons, equals, and clear. There are multiple button listener registrations, using shared methods for the actions.

## Comparison table

| Aspect | Procedural | Event-driven |
|---|---|---|
| Who controls the flow? | Program follows a predefined sequence | User actions/events trigger handlers |
| Can user make mistakes and recover easily? | Limited recovery in this simple version | Clear button allows the user to restart an entry |
| Can user interact in any order? | No; prompts follow a fixed order | More flexible, but valid operations still need a sensible order |
| Possible execution paths | Mostly one defined sequence with branches | Many paths depending on event order |
| Code organization | Instructions are arranged in a sequence | Code is organized around event handlers and response methods |
| User experience | Text-based prompt and response | Interactive graphical interface |

## Reflection (5–7 sentences)

Procedural programming executes instructions in a planned sequence, while event-driven programming responds to events such as button clicks. In the procedural calculator, the user must follow the prompts in the order provided by the program. In the event-driven calculator, the user interacts with graphical buttons and the registered listeners call the appropriate handlers. I prefer event-driven programming for interactive applications because it allows users to control when actions happen. It is suitable for graphical user interfaces because the application can respond to clicks and other user actions. A clear button also makes it easier for a user to recover from an incorrect entry.
