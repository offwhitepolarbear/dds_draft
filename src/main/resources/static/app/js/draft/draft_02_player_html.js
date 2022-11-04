function player_card_tag(player_info){
    let card_color = "border-"
    let postion_color
    if(player_info["position"].toLowerCase() == "c"){
        postion_color = "primary"
    }
    if(player_info["position"].toLowerCase() == "pf"){
        postion_color = "info"
    }
    if(player_info["position"].toLowerCase() == "sf"){
        postion_color = "success"
    }
    if(player_info["position"].toLowerCase() == "sg"){
        postion_color = "secondary"
    }
    if(player_info["position"].toLowerCase() == "pg"){
        postion_color = "dark"
    }

    let player_card = document.createElement('div');
    player_card.id = player_info.playerId
    player_card.classList.add("card", card_color+postion_color);

    let player_card_body = document.createElement('div');
    player_card_body.classList.add("card-body");

    let player_card_title_player_name =  document.createElement('p');
    player_card_title_player_name.classList.add("text-"+postion_color);
    player_card_title_player_name.innerText = player_info["playerName"]

    let player_card_position = document.createElement('span');
    player_card_position.classList.add( "badge", "text-bg-"+postion_color);
    player_card_position.innerText = player_info["position"]

    let player_card_text_star = document.createElement('i');
    player_card_text_star.classList.add("fa", "fa-star")
    player_card_text_star.ariaHidden = "true"

    let player_card_body_second_line = document.createElement("div")
    player_card_body_second_line.appendChild(player_card_position)

    player_card_body_second_line = get_overall_stars(player_card_body_second_line, player_info["overall"])

    player_card_body.appendChild(player_card_title_player_name)
    player_card_body.appendChild(player_card_body_second_line)

    player_card.appendChild(player_card_body)

    return player_card
}

function get_overall_stars(body_tag, overall){

    while (overall>=1){
        body_tag.appendChild(get_star_tag())
        overall -= 1
    }
    if (overall==0.5){
        body_tag.appendChild(get_half_star_tag())
    }
    return body_tag
}

function get_star_tag(){
    let player_card_text_star = document.createElement('i');
    player_card_text_star.classList.add("fa", "fa-star")
    player_card_text_star.ariaHidden = "true"
    return player_card_text_star
}

function get_half_star_tag(){
    let player_card_text_star = document.createElement('i');
    player_card_text_star.classList.add("fa", "fa-star-half")
    player_card_text_star.ariaHidden = "true"
    return player_card_text_star
}