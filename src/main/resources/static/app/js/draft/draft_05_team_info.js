function set_team_main_info(team_info_list){
    team_info_list.forEach(function(team_info){
        all_team_info[team_info["teamName"]] = team_info
        if(team_info["gm"]){
            var img_tag = document.createElement('img');
            img_tag.src = "/file/teamlogo/"+team_info.teamName+".png"
            img_tag.style.width = "5%"
            var img_container = document.createElement("div")
            img_container.appendChild(img_tag)
            var target_id = "team_info"
            if(team_info["pick"]<16){
                target_id += "_left"
            }
            else{
                target_id += "_right"
            }
            document.getElementById(target_id).appendChild(img_container)
        }
    })
    console.log(all_team_info)
}