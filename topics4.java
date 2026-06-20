/* Topics:
1. lamda expression: 
This is used as functionl programming 
*/

public class topics4 {
    public static void main(String[] args ){
        // THis interface will be used to pass new and old state below.
        interface stateChangeListener{
            public void onStateChange();
        }

        //  pass the state in which the changes will be made also called listener, this is the state event listener.
        class stateOwner{
            void addStateListener(stateChangeListener var){
                System.out.println("State is passed in the Listener");
                var.onStateChange();
            };
        }
        
        // instance of stateOwner is created and passed the implementation of interface is passed as arguments instead of another reference variable of stateChangeListener
        stateOwner obj = new stateOwner();
        obj.addStateListener(new stateChangeListener(){
            public void onStateChange(){
                System.out.println("creating the object and passing the arg as anonymous interface");
            }
        });
        
        // we use lamda expression instead of anonymouse inheritance implementaion.
        obj.addStateListener(
            () -> System.out.println("Using the lamda function overwritting the abstract method again of the interface")
        );
    }
};

