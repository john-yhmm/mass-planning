<template>
  <v-app>
    <v-app-bar :elevation="2">
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-app-bar-title>Roman Catholic Mass Planning</v-app-bar-title>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" temporary></v-navigation-drawer>
    <v-main>
      <Home />
    </v-main>
</v-app>
</template>

<script setup>
import Home from '@/components/Home.vue'
import { ref } from 'vue';

let drawer = ref(false);
</script>
