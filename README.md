# 🎙️ TScript AI

<p align="center">
  <h3 align="center">AI Powered Speech-to-Text Transcription System</h3>
  <p align="center">
    Convert audio into text using OpenAI Whisper running locally.
  </p>
</p>

---

# 📌 About The Project

TScript AI is a full-stack AI application that converts audio files into text using the **OpenAI Whisper Speech Recognition Model**.

The project demonstrates how traditional backend systems built using **Java Spring Boot** can integrate with AI models written in **Python**, exposing the functionality through REST APIs and providing a user-friendly React frontend.

This project was built to explore:

- AI Integration in Backend Systems
- Java ↔ Python Communication
- Local AI Inference
- Full Stack Development
- REST API Design
- Speech Recognition Systems

---

#  Features

✅ Upload audio files from browser

✅ Speech-to-Text conversion using AI

✅ OpenAI Whisper running locally

✅ No paid APIs required

✅ React based UI

✅ Spring Boot REST APIs

✅ Temporary file management

✅ Cross-Origin support

✅ Postman tested APIs

✅ Supports multiple audio formats

---

# 🧠 AI Used In This Project

## OpenAI Whisper

Whisper is an Automatic Speech Recognition (ASR) model developed by OpenAI.

### Responsibilities of Whisper:

- Speech Recognition
- Audio Understanding
- Language Detection
- Speech → Text Conversion

---

# ❌ Models NOT Used

| Model | Used |
|--------|------|
| GPT | ❌ |
| Llama | ❌ |
| Ollama | ❌ |
| Gemini | ❌ |

---

# 🏗 Tech Stack

## Frontend

- React.js
- Vite
- Axios
- CSS3

---

## Backend

- Java 17
- Spring Boot
- Spring Web
- Multipart File Upload API

---

## AI Stack

- OpenAI Whisper
- Python 3.11
- PyTorch
- FFmpeg

---

# 🏛 System Architecture

```text
User
  ↓
React Frontend
  ↓
Axios HTTP Request
  ↓
Spring Boot REST API
  ↓
Temporary Audio File
  ↓
Python ProcessBuilder
  ↓
OpenAI Whisper
  ↓
Generated Transcript
  ↓
Frontend Display
```

---

# ⚙️ How It Works

## Step 1

User uploads an audio file.

---

## Step 2

React creates a multipart request.

```javascript
const formData = new FormData();
formData.append("file", file);
```

---

## Step 3

Spring Boot receives the file.

---

## Step 4

Audio is temporarily stored on the server.

---

## Step 5

Java executes Whisper using:

```java
ProcessBuilder
```

Example:

```bash
py -3.11 -m whisper audio.mp3
```

---

## Step 6

Whisper processes the audio using Deep Learning models and generates text.

---

## Step 7

Transcript is returned to frontend.

---

# 🤖 Where Is AI In This Project?

The AI component is:

```text
OpenAI Whisper
```

Whisper is responsible for:

```text
Audio → Feature Extraction
           ↓
Transformer Neural Network
           ↓
Speech Recognition
           ↓
Text Generation
```

Spring Boot only acts as an orchestration layer.

---

# 📂 Project Structure

```text
TScript-AI
│
├── frontend
│   ├── src
│   ├── components
│   ├── App.jsx
│   └── package.json
│
├── backend
│   ├── controller
│   ├── application.properties
│   ├── pom.xml
│   └── TranscriptionController.java
│
├── screenshots
│
└── README.md
```

---

# 📸 Application Preview



## 📸 Application Preview

Upload audio files and generate transcripts instantly.

<p align="center">
  <img width="900" alt="TScript AI UI" src="https://github.com/user-attachments/assets/a79ecd26-4296-4c43-99b6-10be776cf381" />
</p>
---

## Sample Output

### Input Audio

```text
Hello, how are you fitting Spring AI?
```

### Generated Transcript

```text
Hello, how are you fitting Spring AI?
```

---

# API Documentation

## Endpoint

```http
POST /api/transcribe
```

---

## Request Type

```http
multipart/form-data
```

---

## Parameter

| Parameter | Type |
|-----------|------|
| file | MultipartFile |

---

## Example Request

```http
POST http://localhost:8080/api/transcribe
```

---

## Example Response

```json
{
  "transcript":
  "Hello everyone, welcome to TScript AI."
}
```

---

#  API Testing

All APIs were manually tested using **Postman**.

### Tested Scenarios

✅ Valid audio uploads

✅ Invalid files

✅ Empty uploads

✅ Large files

✅ CORS handling

✅ Whisper failures

✅ Backend error handling

---

# 🛠 Installation Guide

## 1️⃣ Clone Repository

```bash
git clone https://github.com/PiyushSaxena05/TScript-AI.git
```

---

## 2️⃣ Install Python Dependencies

```bash
pip install openai-whisper
pip install torch torchvision torchaudio
```

---

## 3️⃣ Install FFmpeg

Verify installation:

```bash
ffmpeg -version
```

---

## 4️⃣ Run Backend

```bash
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

## 5️⃣ Run Frontend

```bash
npm install
npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```

---

# 💻 Example Workflow

```text
1. User uploads audio.
2. React sends file.
3. Spring Boot receives file.
4. Java invokes Python.
5. Whisper transcribes speech.
6. Transcript is generated.
7. Response returned to UI.
```

---

#  Concepts Demonstrated

- Full Stack Development
- REST APIs
- React State Management
- Multipart File Upload
- Java ProcessBuilder
- Python Integration
- AI Model Integration
- Temporary File Management
- Cross-Origin Communication
- Speech Recognition Systems

---

# Challenges Faced

- Node.js PATH configuration
- FFmpeg setup on Windows
- Whisper installation issues
- Python dependency conflicts
- Java ↔ Python communication
- Large AI model downloads
- Managing temporary audio files

---

# 📈 Future Enhancements

- Real-time microphone transcription
- Multi-language support
- Download transcript as PDF/TXT
- Authentication system
- Database integration
- Docker deployment
- Transcript summarization using LLMs
- Speaker diarization
- Cloud deployment

---

# 🎯 Project Highlights

✅ Full Stack AI Application

✅ Local AI Inference

✅ Java + Python Integration

✅ Production-like REST Architecture

✅ Real Working Speech Recognition Pipeline

---



#  Why This Project Matters

TScript AI demonstrates how modern backend systems can integrate Artificial Intelligence models locally without relying on paid APIs.

This project combines:

- Backend Engineering
- Full Stack Development
- AI Integration
- System Design
- Java and Python Interoperability

making it a practical showcase project for Backend and AI Engineering roles.
