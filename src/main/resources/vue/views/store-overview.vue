<template id="store-overview">
    <div class="grid">
        <h1 class="Header">Stores</h1>
        <a class="User" href="">
            Login | Register
        </a>
        <a class="cart" href="">
            Cart
        </a>
    <div class="main">
        <ul class="store-overview-list">
            <li v-for="store in stores" class="storeli">
                <a :href="`/stores/${store.name.trim()}`" class="link-to-store-details">
                    <div class="single-store-container" >
                        <h1>{{store.name}}</h1>

                        <img v-if="store.pictureUrl" class="cover-image-frontpage" v-bind:src="store.pictureUrl">
                        <img v-else class="cover-image-frontpage" src="https://i.pinimg.com/originals/cd/43/c1/cd43c186729dea89d16f7bbe03e434ec.jpg">
                        <a>{{store.location}}</a>
                    </div>
                </a>
            </li>
        </ul>
    </div>
        <aside>
            <p style="color: white">
                Every store location on the website
            </p>
            <ul class="">
                <li v-for="store in stores" class="category">
                    <a>{{store.location}}</a>
                </li>
            </ul>
            <p style="color: white">
                Every category of items on the website
            </p>
            <ul class="item-type-list">
                <li v-for="item in items" class="category">
                    <a>{{item.itemType}}</a>
                </li>
            </ul>
        </aside>
    </div>
</template>
<script>
    Vue.component("store-overview", {
        template: "#store-overview",
        data: () => ({
            stores: [],
            items: [],
        }),
        created() {
            fetch("/api/stores")
                .then(res => res.json())
                .then(res => {
                    this.stores = res;
                })
                .catch(() => alert("Error while fetching stores"));

            fetch(`/api/stores/allitems`)
                .then(res => res.json())
                .then(res => this.items = res)
                .catch(() => alert("Error while fetching items"));
        }
    });
</script>
<style>
    .grid {
        display: grid;
        grid-template-columns: auto;
        grid-template-rows: auto;
        grid-template-areas: "user header header cart"
        "aside main main main";

    }
    .Header{
        grid-area: header;
        color: white;
        font-size: 50px;
        text-align: center;
        border: 1px solid white;
        border-radius: 15px;
        width: 400px;
        padding-top: 0px;
        margin: 0 auto;
    }

    .main{
        grid-area: main;

    }

    .User{
        grid-area: user;
        color: white;
        font-size: 20px;
        text-decoration: none;

    }

    .cart{
        grid-area: cart;
        color: white;
        font-size: 20px;
        text-decoration: none;
        text-align: right;
    }

    aside{
        grid-area: aside;
    }

    .category{

        padding-top: 10px;
    }


    .storeli{
        list-style-type: none;
    }

    .store-overview-list{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .store-overview-list li{
        padding: 10px;
        border: 1px solid white;
        border-radius: 15px;
        margin-right: 30px;
    }

    .link-to-store-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color: white;
    }

    div.single-store-container{
        overflow: hidden;
        width: 250px;
        background-color: #000000;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    div.single-store-container:hover{
        opacity: 1.0;
        overflow: hidden;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image-frontpage {
        height: auto;
        width: 100%;
        padding-bottom: 20px;
        max-height: 280px;
    }

</style>