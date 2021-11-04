<template id="item-detail">
    <div v-if="item" class="detail-item-container">
        {{console.log(this.item)}}
        <h1>{{item.name}}</h1>
        <img v-if="item.pictureUrl" class="cover-image" v-bind:src="item.pictureUrl">
        <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">

        <p>The item is called {{item.name}} and is sold by {{item.storeName}}.
            The item is of type {{item.itemType}},
            and costs: {{item.itemPrice}}
        .</p>
        <p>Dummy text</p>
        <p>
            <a class="button" :href="`/api/stores/${storeName}/items/${item.name}/delete`">Delete</a>
            <a class="button" :href="`/stores/${storeName}/items/${item.name}/update`">Edit</a>
        </p>
    </div>
</template>
<script>
    Vue.component("item-detail", {
        template: "#item-detail",
        data: () => ({
            item: null,
            storeName: "",
        }),
        created() {
            const storeId = this.$javalin.pathParams["store-id"];
            this.storeName = storeId;
            console.log("store id: " + storeId);
            const itemId = this.$javalin.pathParams["item-id"];
            fetch(`/api/stores/${storeId}/items/${itemId}`)
                .then(res => res.json())
                .then(res => this.item = res)
                .catch(() => alert("Error while fetching item"));
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

</style>