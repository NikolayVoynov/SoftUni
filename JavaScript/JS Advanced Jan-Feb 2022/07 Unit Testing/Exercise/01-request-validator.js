function validator(objct) {

    let validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    let uriRegex = /\w+/;
    let validVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    let messageRegex = /[<>\\&'")]+/;

    if (!objct.method || !validMethods.includes(objct.method)) {
        throw new Error('Invalid request header: Invalid Method');
    }

    if (!objct.uri || objct.uri === '' || !uriRegex.test(objct.uri)) {
        throw new Error('Invalid request header: Invalid URI');
    }

    if (!objct.version || !validVersions.includes(objct.version)) {
        throw new Error('Invalid request header: Invalid Version');
    }

    if (objct.message === undefined || messageRegex.test(objct.message)) {
        throw new Error('Invalid request header: Invalid Message');
    }

    return objct;
}


validator({
    method: 'GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1',
    message: ''
}
);