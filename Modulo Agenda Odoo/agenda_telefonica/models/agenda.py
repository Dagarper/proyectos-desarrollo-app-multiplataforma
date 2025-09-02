from odoo import models, fields

class AgendaTelefonica(models.Model):
    _name = 'agenda.telefonica'
    _description = 'Agenda Telefónica'

    name = fields.Char(string='Nombre', required=True)
    phone = fields.Char(string='Teléfono', required=True)