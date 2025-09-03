# -*- coding: utf-8 -*-

from odoo import models, fields, api


class agenda_telefonica(models.Model):
    _name = 'agenda.contacto'
    _description = 'Agenda telefónica de contactos'

    name = fields.Char(string='Nombre', required=True)
    telefono = fields.Char(string='Teléfono', required=True)


