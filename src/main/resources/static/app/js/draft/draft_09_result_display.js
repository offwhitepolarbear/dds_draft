function adjust_place_bid_result(draft_info){
    var i = document.createElement('div');
    i.innerText = draft_info.playerName
    document.getElementById("draftee_list").appendChild(i)
}