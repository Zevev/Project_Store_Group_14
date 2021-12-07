<template id="item-bid">
    <div class="gridBid">
    <div v-if="item" class="detail-item-container">
        {{console.log(this.item)}}
        <h1>{{item.name}}</h1>
        <img v-if="item.pictureUrl" class="cover-image" v-bind:src="item.pictureUrl">
        <img v-else class="cover-image" src="https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-1-scaled-1150x647.png">

        <p>Price of {{item.name}} is {{item.itemPrice}}
            </p>
        <p>If the price of the item doesnt change, your bid is too low!</p>
    </div>
        <div class="form-style">
            <h2>Current bid: {{item.itemPrice}} nok.</h2>
            <form class="create" @submit="checkForm" :action=`/api/stores/${storeName}/items/${item.name}/bid` method="post">
                <div v-if="errors.length">
                    <b>Please correct the following error(s):</b>
                    <ul>
                        <li v-for="error in errors">{{ error }}</li>
                    </ul>
                </div>

                <p>
                    <label for="itemPrice">Bid<label>
                        <input type="number" step="0.000001" name="itemPrice" id="itemPrice" v-model="itemPrice" min="0">
                </p>

                <p>
                    <input type="submit" value="Bid">
                </p>

            </form>
        </div>
    </div>


</template>
<script>
    Vue.component("item-bid", {
        template: "#item-bid",
        data: () => ({
            item: null,
            name: null,
            itemType: null,
            pictureUrl: null,
            itemPrice: null,
            storeName: "",
            errors: []
        }),
        created() {
            const storeId = this.$javalin.pathParams["store-id"];
            this.storeName = storeId;
            this.storeName = this.$javalin.pathParams["store-id"];
            console.log("store id: " + storeId);
            const itemId = this.$javalin.pathParams["item-id"];
            fetch(`/api/stores/${storeId}/items/${itemId}`)
                .then(res => res.json())
                .then(res => this.item = res)
                .catch(() => alert("Error while fetching item"));

        },
        methods:{
            checkForm:function(e) {
                const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
                if(this.itemPrice) return true;
                this.errors = [];
                if (!this.itemPrice) this.errors.push("Price required");
                e.preventDefault();
            }
        }
    });
</script>
<style>
    ul{
        color:white;
    }
    div.detail-item-container > p {
        max-width: 30em;
    }
    div.detail-item-container{
        padding-top: 10px;
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        color: white;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.item-cover-image {
        height: 320px;
        width: 320px;
        padding-bottom: 20px;
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid white;
    }
    .form-style{

        width: 500px;
        padding: 30px;
        background: #191919;
        margin: 50px auto;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);
        border: #dddddd;
    }
    .form-style h2{
        background: #4D4D4D;
        text-transform: uppercase;
        font-family: 'Open Sans Condensed', sans-serif;
        color: #FFFFFF;
        font-size: 18px;
        font-weight: 100;
        padding: 20px;
        margin: -30px -30px 30px -30px;
    }
    .form-style input[type="text"],
    .form-style input[type="date"],
    .form-style input[type="datetime"],
    .form-style input[type="email"],
    .form-style input[type="number"],
    .form-style input[type="search"],
    .form-style input[type="time"],
    .form-style input[type="url"],
    .form-style input[type="password"],
    .form-style textarea,
    .form-style select
    {
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        outline: none;
        display: block;
        width: 100%;
        padding: 7px;
        border: none;
        color: white;
        border-bottom: 1px solid #ddd;
        background: transparent;
        margin-bottom: 10px;
        font: 16px Arial, Helvetica, sans-serif;
        height: 45px;
    }
    .form-style textarea{
        resize:none;
        overflow: hidden;
    }
    .form-style input[type="button"],
    .form-style input[type="submit"]{
        background: none;
        display: inline-block;
        cursor: pointer;
        font-family: 'Open Sans Condensed', sans-serif;
        font-size: 14px;
        text-decoration: none;
        text-transform: uppercase;
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }
    .form-style input[type="button"]:hover,
    .form-style input[type="submit"]:hover {
        border: 2px solid white;
    }

    .create {
        color: white;
    }

</style>