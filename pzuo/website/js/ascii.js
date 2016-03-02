"use strict";
//http://mumstudents.org/cs472/2016-03-AS-KL/Homework/
window.onload = function() {
    //document.getElementById("mytextarea").value=JUGGLER;
    
    switch(asel.value) {
        case "Blank":
            var t =BLANK.split("=====\n");
        case "Exercise":
            var t =EXERCISE.split("=====\n");
        case "Juggler":
            var t =JUGGLER.split("=====\n");
        case "Bike":
            var t =BIKE.split("=====\n");
        case "Dive":
            var t =DIVE.split("=====\n");
        default:
            break;
    }

    var isStoped = false;
    var index = 0;
    var bstart = document.getElementById("start");
    var bstop = document.getElementById("stop");
    var timer;
    var ssl = document.getElementById("ssel");
    /*

    ssl.onchange = function() {
        switch(ssel.value) {
            case "Tiny":
                var ft = 7pt;
            default:
                break;
        }
    }
    */
    bstart.onclick = function() {
        timer = setInterval(myTimer,250);
        document.getElementById("stop").disabled = false;
    }
    bstop.onclick = function() {
        clearInterval(timer);
        document.getElementById("stop").disabled = true;

    }
    
    function myTimer() {
        if(index >= t.length)
            index = 0;
        document.getElementById("mytextarea").value = t[index++];
    }
    

}

