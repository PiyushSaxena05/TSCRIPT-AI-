import { useState } from "react";
import axios from "axios";

const AudioUploader = () => {

    const [file, setFile] = useState(null);
    const [transcription, setTranscription] = useState("");

    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    };

    const handleUpload = async () => {

        if (!file) {
            alert("Please select an audio file first!");
            return;
        }

        const formData = new FormData();
        formData.append("file", file);

        try {

            const response = await axios.post(
                "http://localhost:9091/api/transcribe",
                formData
            );

            setTranscription(response.data);

        } catch (error) {
            console.error(
                "Error transcribing audio:",
                error
            );

            alert("Failed to transcribe audio.");
        }
    };

    return (
        <div className="container">

            <h1>TSCRIPT AI</h1>

            <div className="file-input">
                <input
                    type="file"
                    accept="audio/*"
                    onChange={handleFileChange}
                />
            </div>

            <button
                className="upload-button"
                onClick={handleUpload}
            >
                Upload and Transcribe
            </button>

            <div className="transcription-result">
                <h2>Transcription Result</h2>

                <p>
                    {transcription
                        ? transcription
                        : "No transcription yet."}
                </p>
            </div>

        </div>
    );
};

export default AudioUploader;