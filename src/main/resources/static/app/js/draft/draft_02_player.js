// 


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
	console.log(all_player_info["artero01"]["playerName"])
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
function get_rest_player_from_api(){
	
}

function set_rest_player(rest_players_json){
	rest_players_json.forEach(function(rest_player){
		console.log(rest_player)
	})
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

