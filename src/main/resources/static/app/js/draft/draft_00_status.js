let gm_info = new Object();
let all_player_info = new Object();
let all_team_info = new Object();
let nominatability_own;
let biddability_own;
let on_bid_info;
let last_bid;
let left_time;
let draftees;
let undraftees = new Array();

function set_nominatability(bool){
    nominatability_own = bool
}

function set_biddability(bool){
    biddability_own = bool
}