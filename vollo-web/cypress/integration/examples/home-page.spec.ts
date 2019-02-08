describe('Home Page', () => {
  beforeEach(() => {
    cy.visit('http://localhost:4200');
  });

  it('moet de homepage laten zien', () => {
    expect(cy.contains('Vollo'));
  });

  it('moet inloggen', () => {
    inloggen('m1');

    expect(cy.contains('Welkom terug'));
  });

  it('moet gebruikermenu tonen', () => {
    inloggen('m1');

    cy.get('[aria-label="Gebruikermenu"]').click();

    expect(cy.contains('Ingelogd als m1'));
    expect(cy.contains('Uitloggen'));
  });

  it('moet uitloggen', () => {
    inloggen('m1');
    cy.get('[aria-label="Gebruikermenu"]').click();

    cy.get('[aria-label="Uitloggen"]').click();

    cy.get('[aria-label="Gebruikermenu"]').should('be.disabled');
  });

  function inloggen(gebruiker: string) {
    cy.get('[name="gebruikersnaam"]').type(gebruiker);
    cy.get('[name="wachtwoord"]').type(gebruiker);
    cy.get('button[type="submit"]').click();
  }
});