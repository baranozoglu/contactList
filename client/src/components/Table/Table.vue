<template>
  <el-table
    v-loading="loading"
    element-loading-text="Loading..."
    element-loading-spinner="el-icon-loading"
    element-loading-background="rgba(0, 0, 0, 0.4)"
    :data="data"
    style="width: 100%"
  >
    <el-table-column prop="id" label="ID"> </el-table-column>
    <el-table-column prop="url" label="Image">
      <template slot-scope="scope">
        <img :src="scope.row.url" style="max-height: 150px" />
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
    loading: {
      type: Boolean,
      required: false,
    },
  },
};
</script>
