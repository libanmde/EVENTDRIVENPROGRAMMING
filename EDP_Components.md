# Activity 1: Spot the Components

| System | Event source | Event | Listener | Handler/action |
|---|---|---|---|---|
| ATM machine | Keypad button | Button pressed | ATM software / keypad listener | Read the selection or PIN digit and validate the input |
| Microwave oven | Door sensor | Door opened | Microwave control system | Pause heating for safety |
| Traffic light | Timer | Timer interval expires | Traffic-light controller | Change to the next light phase |
| Video game | Keyboard | Movement key pressed | Game input listener | Move the player in the requested direction |
| Elevator | Floor-selection button | Floor button pressed | Elevator controller | Add the requested floor to the destination list |
| Smartphone | Touchscreen | App icon tapped | Operating system / app listener | Open the selected application |
| YouTube player | Play button | Play button clicked | Video player listener | Start or resume video playback |
| Online shopping website | Add-to-cart button | Button clicked | Website event listener | Add the selected item to the shopping cart |

## Self-check questions

### 1. What is the difference between an event source and an event listener?
An event source is the component that produces an event, such as a button or keyboard. An event listener is the component or registered object that waits for a particular event and receives notification when it occurs.

### 2. Can one event source have multiple listeners? Give an example.
Yes. One source can notify more than one listener. For example, when a user clicks a submit button, one listener could validate the form while another listener records an interaction for logging.

### 3. Can one listener handle events from multiple sources? Give an example.
Yes. A listener can be registered with more than one source. For example, one shared action listener could respond to several menu buttons and check which button generated the event.

## Note
The listener receives or detects the event; the handler contains the action performed in response. In some programming examples, these roles are implemented together.
