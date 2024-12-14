/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",         // Add this line to scan the root HTML file
    "./src/**/*.{html,js,jsx,ts,tsx}",  // This will scan all your source files
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
