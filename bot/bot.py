from telegram import Update
from telegram.ext import (
    ApplicationBuilder, CommandHandler, MessageHandler, filters, CallbackContext
)
import asyncio

# Replace with your bot token
TOKEN = "7518957183:AAG9m2t0RG2vIyUfSQxAIEwDinCAt-aQQc4"

# Predefined FAQ responses
faq_responses = {
    "price kya hai": "Prices start from ₹399. Get more details by using /pricing.",
    "kaise order karna hai": "Order by emailing us your Name, Branch, and Project Name. Use /contact for details.",
    "kaise payment karna hai": "Buy an Amazon Gift Card and send us the code. After payment, you will receive the project ZIP.",
    "email kya hai": "Our email: anyproject@rediffmail.com",
    "git repo kya hai": "GitHub Repository: https://github.com/projectany",
    "tum kon ho": "Main ek Telegram bot hoon, jo aapko web development projects ke details provide karta hoon.",
    "delivery time kya hai": "Project delivery usually takes 24-48 hours after payment confirmation.",
    "discount hai kya": "Haan! ₹50 OFF on orders above ₹500. ₹100 OFF on orders above ₹1000.",
    "refund policy kya hai": "Sorry, payment once done is non-refundable.",
    "free me milega":"jab hoga to aap ko email kar diya jayega"
}

async def start(update: Update, context: CallbackContext) -> None:
    await update.message.reply_text("Welcome! I am your Web Development Project Bot. Use /help to see available commands.")

async def help_command(update: Update, context: CallbackContext) -> None:
    commands = """
/start - Start the bot and get a welcome message
/help - Get a list of available commands
/about - Learn more about the bot and its features
/pricing - Find the cheapest price for web development projects
/find - Search for a specific web development project
/track - Track price changes for a project over time
/projects - View a list of available web development projects
/contact - Get support or ask questions
/repo - Get the GitHub repository link
    """
    await update.message.reply_text(commands)

async def about(update: Update, context: CallbackContext) -> None:
    await update.message.reply_text("This bot helps you find and track web development projects at the best prices!")

async def pricing(update: Update, context: CallbackContext) -> None:
    await update.message.reply_text("Prices start from ₹399. Get more details by using /projects.")

async def custom_response(update: Update, context: CallbackContext) -> None:
    user_message = update.message.text.lower()
    response = faq_responses.get(user_message, "Sorry, mujhe ye samajh nahi aaya. Aap /help use karein.")
    await update.message.reply_text(response)

def main():
    app = ApplicationBuilder().token(TOKEN).build()

    # Command handlers
    app.add_handler(CommandHandler("start", start))
    app.add_handler(CommandHandler("help", help_command))
    app.add_handler(CommandHandler("about", about))
    app.add_handler(CommandHandler("pricing", pricing))

    # Message handler for custom FAQ responses
    app.add_handler(MessageHandler(filters.TEXT & ~filters.COMMAND, custom_response))

    print("Bot is running...")
    app.run_polling()

if __name__ == "__main__":
    main()
