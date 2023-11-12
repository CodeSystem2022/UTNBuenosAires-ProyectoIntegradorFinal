describe('Pruebas de la página HTML', () => {
    // Aquí irán las pruebas individuales
  })
  it('Debería mostrar el título de la página', () => {
    // Comandos para realizar la prueba

    cy.visit('http://localhost:3000/index.html') // URL local
    cy.visit('https://example.com') // URL remota
    cy.visit('file:///C:/Users/usuario/Desktop/index.html') // Archivo local

    cy.get('h1') // Selector CSS
    cy.get('[data-cy="submit-button"]') // Atributo data-cy
    cy.get('h1').should('have.text', 'Grupo UTN Bs As - Ecommerce para Proyecto Final (UTN FRSR)') // Verificar el texto del elemento
    cy.get('[data-cy="submit-button"]').should('be.disabled') // Verificar el estado del elemento
    
    cy.get('[data-cy="username-input"]').type('admin') // Escribir texto
    cy.get('[data-cy="password-input"]').type('1234{enter}') // Escribir texto y presionar enter

    cy.get('[data-cy="submit-button"]').click() // Hacer clic normal
    cy.get('[data-cy="cancel-button"]').click({ force: true }) // Hacer clic forzado

    cy.contains('Bienvenido').should('be.visible') // Verificar que el texto sea visible
    cy.contains('Iniciar sesión').click() // Hacer clic en el elemento que contiene el texto
    
  })
    