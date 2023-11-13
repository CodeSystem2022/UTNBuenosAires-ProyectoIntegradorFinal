cy.intercept('POST', '/login').as('login') // Interceptar la petición POST a /login y asignarle un alias
cy.wait('@login').its('response.statusCode').should('eq', 200) // Esperar a la petición y verificar el código de respuesta
cy.intercept('GET', '/profile', { fixture: 'profile.json' }) // Interceptar la petición GET a /profile y devolver una respuesta desde un archivo
cy.intercept('GET', '/products', { statusCode: 500, body: 'Error' }) // Interceptar la petición GET a /products y devolver un error
