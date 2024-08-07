import { defineStore } from "pinia";
import axios from "axios";

export const userBasicStore = defineStore("userBasic", {
    state: () => ({userInfoDetail:
        {
            "name": "",
            "password": "",
            "birth": "",
            "email": "",
            "sex": "",
            "address": "",
            "postCode": 0,
            "phoneNumber": "",
            "couponList": [
              {
                "couponName": "",
                "couponPrice": 0,
                "couponContent": "",
                "minOrderPrice": 0
              }
            ],
            "deliveryAddressList": [
              {
                "addressName": "",
                "addressInfo": "",
                "addressDefault": true,
                "postCode": 0
              }
            ],
            "userPoint": 0
          },
    "deliveryAddressIdx": 0}),
    actions: {
        async userDetail(){            
            const response = await axios.get("/api/user/info/detail", {withCredentials: true});
            this.userInfoDetail = response.data.result;
            console.log(this.userInfoDetail);
        },
        async saveAddr(deliveryAddressRegisterRequest){
          
          const response = await axios.post("/api/user/delivery/register",deliveryAddressRegisterRequest, {withCredentials: true})
          console.log(response.result);
          this.userDetail();
          
        }
    }
})