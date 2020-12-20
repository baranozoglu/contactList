<template>
  <el-table :data="data" style="width: 100%" >
    <el-table-column prop="id" label="ID"> </el-table-column>
    <el-table-column prop="url" label="Image" max-height="150px">
      <template slot-scope="scope">
        <img :src="scope.row.url" />
      </template>
    </el-table-column>
    <el-table-column prop="name" label="Name"> </el-table-column>
  </el-table>
</template>

<script>
export default {
  data: function() {
    return { 
      input: null,
    };
  },
  props: {
    data: {
      type: Array,
      required: false,
    },
  },
};
</script>
