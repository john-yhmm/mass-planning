<template>
  <v-row justify="center" no-gutters>
    <v-col cols="5" sm="4" md="3" lg="2" xl="1">
      <v-sheet class="pt-6">{{ label }}</v-sheet>
    </v-col>
    <v-col cols="7" sm="5" md="4" lg="3" xl="2">
      <v-text-field :placeholder="label" variant="underlined" hide-details>
        <template v-slot:append>
          <v-tooltip location="left">
            <template v-slot:activator="{ props }">
              <v-btn
                v-bind="props"
                :loading="buttonLoading"
                @click.stop="clicked"
                icon="mdi-plus"
                variant="outlined"
                size="x-small"
              >
              </v-btn>
            </template>
            <span>Choose {{ label }}</span>
          </v-tooltip>
        </template>
      </v-text-field>
    </v-col>
  </v-row>
</template>
<script>
export default {
  name: "Item",
  props: {
    label: String,
  },
  data() {
    return {
      buttonLoading: false,
    };
  },
  methods: {
    clicked() {
      this.buttonLoading = !this.buttonLoading;
      setTimeout(() => {
        this.buttonLoading = !this.buttonLoading;
      }, 2000);
    },
  },
};
</script>
