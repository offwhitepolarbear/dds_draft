// 남은 시간
function get_rest_draft_time_from_api(){
        let url = "/draft/getRemainTime"
        fetch(url,
            {
                    method: 'GET', // or 'PUT'
                    headers:{
                            'Content-Type': 'application/json'
                    }
            }
        )
            .then(res => res.json())
            .then(response_json => set_bid_timer(response_json))

}

function place_bid(){
    // if(biddability_own){
        let body = Object()
        body["season"] = gm_info.season
        // body["pick"]
        body["playerId"] = document.getElementById("bid_player_info").firstChild.id
        body["bidTeam"] = gm_info.teamName
        // if (all_team_info[gm_info.teamName]){
        //
        // }
        body["bidPlayer"] = gm_info.teamName
        body["bidPrice"] = document.getElementById("bid_price").value
        body["nominate"] = false

    set_last_bid(body)
    // }
}

function set_last_bid(last_bid){
    on_bid_info = last_bid
    // 입찰 팀 이미지 태그 처리

    set_bid_timer(22)
    set_last_bid_price(last_bid.bidPrice)
    set_last_bid_team(last_bid.bidTeam)
    // document.getElementById("bid_info").appendChild()
}

function set_bid_timer(time){
    document.getElementById("draft_timer").innerText = time
}

function set_last_bid_price(price){
    document.getElementById("last_bid_price").innerText = price
}

function set_last_bid_team(team_name){
    document.getElementById("last_bid_team").firstChild.remove()
    document.getElementById("last_bid_team").appendChild(team_logo_img_tag(team_name))
}

function team_logo_img_tag(team_name){
    let img_tag = document.createElement('img');
    img_tag.src = "/file/teamlogo/" + team_name + ".png"
    img_tag.style.width = "30%"
    return img_tag
}

function set_bidability(){

}

function check_bidability(){
	
}

function check_bid_price(){
	
}

function check_last_bid_team(){
	
}

function bid_approval(){
	
}