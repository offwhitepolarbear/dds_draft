/*
 * 서버에서 보내줘야 되는거
 * 남은시간
 * 지금 접속중인 애들 명단
 * */
function get_draft_teams_from_api(){
	var url = "/draft/team/getDraftTeams/" + gm_info.season;
	fetch(url, 
			{
			  method: 'GET', // or 'PUT'
			  headers:{
			    'Content-Type': 'application/json'
			  }
			}
		)
		.then(res => res.json())
		.then(response_json => set_draft_teams(response_json))
}

function set_draft_teams(teams){
	console.log(teams)
	set_team_main_info(teams)
}

function get_all_player(){
	var url = '/rest/player/getAllPlayer/' + gm_info.season;
	fetch(url,
		{
			method: 'GET',
			headers:{
				'Content-Type': 'application/json'
			}
		}
	)
		.then(res => res.json())
		.then(response_json => set_all_player_map(response_json))
}

function set_all_player_map(player_list){
	player_list.forEach(function(player){
		all_player_info[player.playerId] = player

	})
}



// 지금 드래프트 중인 선수
function get_player_on_bid_from_api(){
	var url = '/rest/player/getUndraftPlayer/' + gm_info.season;
	fetch(url, 
			{
			  method: 'GET', // or 'PUT'
			  headers:{
			    'Content-Type': 'application/json'
			  }
			}
		)
		.then(res => res.json())
		.then(response_json => set_player_on_bid(response_json))
		
}

function set_player_on_bid(player_json){
	console.log(player_json)
}

// 남은 시간
function get_rest_draft_time_from_api(){
	var url = "/draft/getRemainTime"
	fetch(url, 
			{
			  method: 'GET', // or 'PUT'
			  headers:{
			    'Content-Type': 'application/json'
			  }
			}
		)
		.then(res => res.json())
		.then(response_json => set_rest_draft_time(response_json))
			
}

function set_rest_draft_time(time){
	console.log(time)
}

// 전체 남은 선수
function get_undraftee_from_api(){
	var url = '/rest/player/getUndraftPlayer/' + gm_info.season;
	fetch(url,
		{
			method: 'GET', // or 'PUT'
			headers:{
				'Content-Type': 'application/json'
			}
		}
	)
		.then(res => res.json())
		.then(response_json => set_undraft_player(response_json))

}

function set_undraft_player(undraft_players_json){

	undraft_players_json = player_sort_overall_desc(undraft_players_json)

	undraft_players_json.forEach(function(undraft_player){

		let player_card = player_card_tag(undraft_player)

		// 클릭 이벤트 처리
		player_card.setAttribute("value", "true")
		player_card.addEventListener("click", event => check_nominate_player(player_card.id))

		let card_player_info = all_player_info[player_card.id]
		let card_position = "undraft_player" + "_" + card_player_info['position'].toLowerCase()
		document.getElementById(card_position).appendChild(player_card)
	})
}
function player_sort_overall_desc(undraft_players){

	undraft_players.sort(function(player_a, player_b){
		let result = 0
		let a_overall = player_a["overall"]
		let b_overall = player_b["overall"]

		if (a_overall == b_overall){

		}
		if (a_overall>b_overall){
			result = -1
		}
		if (a_overall<b_overall){
			result = 1
		}
		return result
	})

	return undraft_players
}

// 드래프트 된 선수
function get_dratee_from_api(){
	var url = "/draft/getRemainTime"
		fetch(url, 
				{
				  method: 'GET', // or 'PUT'
				  headers:{
				    'Content-Type': 'application/json'
				  }
				}
			)
			.then(res => res.json())
			.then(response_json => set_rest_draft_time(response_json))
}

function set_draftee(draftee_json){
	draftee_json.forEach(function(draftee){
		console.log(draftee)
	})
}

function check_nominate_player(player_id){
	let selectable = document.getElementById(player_id).getAttribute("value")
	if (selectable){
		let player_info = all_player_info[player_id]
		let confirm_event = confirm(player_info["playerName"]+ "을 입찰 후보로 올립니다.")
		if (confirm_event) {
			alert(player_info["playerName"]+'후보로 올림')
			nominate_player(player_id)
		}
		else{
			// 취소 클릭 그냥 아무 이벤트 없이 ㄱ
		}
		return confirm_event
	}

}

function nominate_player(player_id){
	let bid_tag = document.getElementById("bid_player_info")

	if (bid_tag.hasChildNodes()){
		bid_tag.removeChild(bid_tag.firstChild)
	}

	let player_tag = document.getElementById(player_id)
	player_tag.removeAttribute("value")
	document.getElementById("bid_player_info").appendChild(player_tag)

}

function check_player_bid(bid_info){

	let confirm_event = confirm("$ xx 입찰을 합니다")
	if (confirm_event) {

		bid_player()
	}
	else{
		// 취소 클릭 그냥 아무 이벤트 없이 ㄱ
	}
	return confirm_event
}

function bid_player(){
	// 통신 이후 결과값 전송 ㄱ
}