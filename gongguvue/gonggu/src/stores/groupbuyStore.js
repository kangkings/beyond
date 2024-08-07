import { defineStore } from "pinia";
import axios from "axios";

export const groupbuyStore = defineStore("groupbuy", {
    state: () => ({gpbuyList:[
        {
            "gpbuyIdx": 0,
            "gpbuyQuantity": 0,
            "gpbuyRemainQuantity": 0,
            "productThumbnailImg": "",
            "productName": "",
            "bidPrice": 0,
            "companyName": "",
            "gpbuyStartedAt": "",
            "gpbuyEndedAt": "",
            "duration": "string"
          }
    ]}),
    actions: {
        async gpbuySearch(request){            
            const response = await axios.get("/api/gpbuy/list",request);
            this.gpbuyList = response.data.result;
        },
    }
})