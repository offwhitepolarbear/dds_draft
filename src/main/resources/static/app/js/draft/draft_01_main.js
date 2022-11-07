let host_url_full = window.location.href;

host_url_full = host_url_full.split('/');

const socket_url = "ws://"+host_url_full[2]+"/socket";

let info_uri = window.location.pathname;

info_uri = info_uri.split('/')


gm_info.season = info_uri[2];
gm_info.teamName = info_uri[3];
gm_info.password = info_uri[4];

let websocket;


gm_login()

function gm_login(){

		let login_url = '/draft/login';
		let data = gm_info;
		fetch(login_url, 
			{
			  method: 'POST', // or 'PUT'
			  body: JSON.stringify(data),
			  headers:{
			    'Content-Type': 'application/json'
			  }
			}
		)
		.then(res => res.json())
		.then(response => loginCheck(response))
		.catch(error => console.error('Error:', error));
	
}

function loginCheck(response){
	
	// 로그인 실패시
	if(response==false){
		alert('주소를 다시 확인해 주세요');
	}
	// 로그인 성공시
	if(response==true){
		// 웹 소켓 연결
		socket_connect(gm_info)
		// 페이지 들어왔을 때 필요한 정보들 가져오기

		// 드래프트 기본 정보
		get_draft_info()
		// 전체 로스터 id 매핑
		get_all_player()

		// 팀 정보
		get_draft_teams_from_api()

		// 언드래프티 할당
		get_undraftee_from_api()

		// 지금 드래프트 중인 선수
		get_player_on_bid_from_api()
		// 남은 시간
		get_rest_draft_time_from_api()

		// 드래프트 된 선수
		get_dratee_from_api()
		
		//채팅 로딩
		
	}
}

function socket_connect(gm_info){
	// gm_info
	websocket = new WebSocket(socket_url);

	// 웹소켓 오픈 이벤트
	websocket.onopen = function (evt) {
		
	    console.log("열림"+evt);
	    websocket.send(JSON.stringify(gm_info));
	};

	// 웹소켓 메시지 이벤트
	websocket.onmessage = function (evt) {
		console.log("웹소켓 메세지 도착");
		message_handler(evt)
	};

	// 웹소켓 에러 이벤트
	websocket.onerror = function (evt) {
		 console.log("에러남"+evt);
		 console.log(evt);
		 console.log(evt.code);
		 console.log(JSON.stringify(evt));
		 
	};
}


function message_handler(message){
	let message_json = JSON.parse(message.data)
	let message_type = message_json.socketMessageType
	let message_object = message_json.object
	console.log(message_type)
	if (message_type == "PLACE_BID"){
		adjust_place_bid_result(message_object)
	}
}
