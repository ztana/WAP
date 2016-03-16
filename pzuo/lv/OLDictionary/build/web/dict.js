/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the e ditor.
 */

$(function(){
    $("#lookup").click(lookupDic);
});

function lookupDic(){
    var wd = $("#word").attr("value");
    $.ajax("dictServlet",{
        "type" : "get",
        "data" : {
            "word" : wd
        }
    }).done(display);
}

function display(data) {
    $("#result").html(data);
}