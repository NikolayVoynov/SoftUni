interface IRequestData {
    method: string;
    uri: string;
    version: string;
    message: string;
}

class RequestData implements IRequestData {
    public response: undefined;
    public fulfilled: boolean;

    constructor(
        public method: string,
        public uri: string,
        public version: string,
        public message: string,
    ) {
        this.response = undefined;
        this.fulfilled = false;
    }
}

export default RequestData;