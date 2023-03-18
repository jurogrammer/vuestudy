<template>
  <div class="contact">
    <h1>Contact Me</h1>
    <form @submit.prevent="submitForm">
      <div>
        <label for="name">Name:</label>
        <input type="text" id="name" v-model="name" required/>
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" required/>
      </div>
      <div>
        <label for="message">Message:</label>
        <textarea id="message" v-model="message" required></textarea>
      </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'MainContact',
  data() {
    return {
      name: '',
      email: '',
      message: '',
    };
  },
  methods: {
    submitForm() {
      // You can add your form submission logic here
      console.log(`Name: ${this.name}`);
      console.log(`Email: ${this.email}`);
      console.log(`Message: ${this.message}`);
      // Clear form fields
      this.name = '';
      this.email = '';
      this.message = '';
    },
  },
});
</script>

<style scoped>
.contact {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

form {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

label {
  font-weight: bold;
}

input,
textarea {
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button {
  padding: 10px;
  background-color: #0077cc;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>
