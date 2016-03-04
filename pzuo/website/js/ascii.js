"use strict";
//http://mumstudents.org/cs472/2016-03-AS-KL/Homework/
window.onload = function() {
    //document.getElementById("mytextarea").value=JUGGLER;
    

	var t;
    var isStoped = false;
    var index = 0;
    var bstart = document.getElementById("start");
    var bstop = document.getElementById("stop");
    var timer;
    var ssl = document.getElementById("ssel");
    var speed = document.getElementById("speed");
	var aniSpeed = 250;

    ssl.onchange = function() {
        switch(ssel.value) {
            case "Tiny":
                makeSize(7);
				break;
			case "Small":
                makeSize(10);
				break;
			case "Medium":
                makeSize(12);
				break;
			case "Large":
                makeSize(16);
				break;
			case "Extra Large":
                makeSize(24);
				break;
			case "XXL":
                makeSize(32);
				break;
            default:
                break;
        }
    }
    
	speed.onchange = function() {
		if(speed.checked == "checked") {
			aniSpeed =50;
		}
		else {
			aniSpeed=250;
		}
	}
	function makeSize(size) {
			document.getElementById("mytextarea").style.fontSize = size + 'pt';
	}
	
	
	
    bstart.onclick = function() {
		switch(asel.value) {
			case "Blank":
				 t =BLANK.split("=====\n");
				 break;
			case "Exercise":
				 t =EXERCISE.split("=====\n");
				 break;
			case "Juggler":
				 t =JUGGLER.split("=====\n");
				 break;
			case "Bike":
				 t =BIKE.split("=====\n");
				 break;
			case "Dive":
				 t =DIVE.split("=====\n");
				 break;
			default:
				break;
		}
        timer = setInterval(myTimer,aniSpeed);
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

