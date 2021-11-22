<template id="purchase">
    <div v-if="item" class="detail-item-container">



        <p>Purchase options</p>

    </div>
</template>
<script>
    Vue.component("purchase", {
        template: "#purchase",
        data: () => ({

        }),
        created() {

        }
    });
</script>
<style>
    ul{
        color:white;
    }

    .list{
        list-style-type: none;
        display: grid;
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