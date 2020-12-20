<template>
  <div id="app">
    <Table />
  </div>
</template>

<script>
import Table from "./components/Table/Table";
export default {
  name: "App",
  components: {
    Table,
  },
  data() {
    return {
      tableData: [
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
        {
          id: "1",
          name: "Tom",
          url: "No. 189, Grove St, Los Angeles",
        },
      ],
    };
  },
  mounted() {
    // var header = {
    //   "Cache-Control": "no-cache",
    //   Pragma: "no-cache",
    //   "Axios-Call": "true",
    //   "Referrer-Policy": "no-referrer",
    //   "Access-Control-Allow-Methods": "GET",
    //   "Access-Control-Allow-Origin": "*",
    // };
    // var paramsUpload = {
    //   csvName: "people",
    // };
    // var paramsPeople = {
    //   name: "",
    //   page: null,
    //   size: null,
    // };
    //var urlUpload = "http://localhost:8080/contactList/upload?csvName=people";
    //var urlPeople = "http://localhost:8080/contactList/people";

    // axios.get(urlUpload, { headers: header }).then((response) =>
    //   (this.data = response.data.peopleList).catch(function(error) {
    //     console.log('error :>> ', error);
    //   })
    // );
    console.log("this.data :>> ", this.tableData);
    // axios({
    //   url: url,
    //   method: "GET",
    //   data: params,
    //   headers: header,
    // }).then((response) => (this.info = response.data.peopleList));
    // axios
    //     .get("http://localhost:8080/contactList/upload", config, params)
    //     .then((response) => (this.info = response))
    //     .then(
    //       axios
    //         .get("http://localhost:8080/contactList/people")
    //         .then((response) => (this.info = response.data.peopleList))
    //     );
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
