function get_draft_info(season){
    let url = '/draft/info/' + gm_info.season;
    fetch(url,
        {
            method: 'GET',
            headers:{
                'Content-Type': 'application/json'
            }
        }
    )
        .then(res => res.json())
        .then(response_json => console.log(response_json))
}